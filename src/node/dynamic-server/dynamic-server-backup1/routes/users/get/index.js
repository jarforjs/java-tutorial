var fs=require('fs');
module.exports=function (query,request,response) {
    var id = query.id;
    if (id) {
        fs.readFile(Db_NAME, 'utf8', function (err, data) {
            if (err) {
                response.statusCode = 500;
                response.end(JSON.stringify({code: 'error', data: err}));
            } else {
                response.writeHead(200, {
                    'Content-Type': 'application/json;charset=utf-8'
                });
                var users = JSON.parse(data);
                var user = users.filter(function (user) {
                        return user.id == id;
                    })[0] || {};
                response.end(JSON.stringify({code: 'success', data: user/*JSON.parse(data)*/}));
            }
        });
    } else {
        fs.readFile(Db_NAME, 'utf8', function (err, data) {
            if (err) {
                response.statusCode = 500;
                response.end(JSON.stringify({code: 'error', data: err}));
            } else {
                response.writeHead(200, {
                    'Content-Type': 'application/json;charset=utf-8'
                });
                try {
                    var users = JSON.parse(data);
                } catch (e) {
                    var users = [];
                }
                var reg = new RegExp(query.keyword);
                var orderBy = query.orderBy || 'id';
                var order = query.order || 'asc';
                order = order == 'desc' ? -1 : 1;
                //过滤,排序(查询),分页
                var pageNum = query.pageNum ? Number(query.pageNum) : 1;
                var pageSize = query.pageSize ? Number(query.pageSize) : 2;
                var filterUsers = users.filter(function (user) {
                    if (query.keyword) {
                        return reg.test(user.name)
                    } else {
                        return true;
                    }
                }).sort(function (a, b) {
                    if (typeof a[orderBy] == 'string') {
                        return (a[orderBy].localeCompare(b[orderBy])) * order;
                    } else {
                        return (a[orderBy] - b[orderBy]) * order;
                    }
                }).slice((pageNum-1)*pageSize,pageNum*pageSize);
                //response.end(JSON.stringify({code: 'success', data: JSON.parse(data)}));
                response.end(JSON.stringify({code: 'success', data: {users:filterUsers,totalPage:Math.ceil(users.length/pageSize),pageNum:pageNum}}));
            }
        });
    }

};