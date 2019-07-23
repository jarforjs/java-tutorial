//读取后台接口得到所有的用户列表并加到表格当中
list1();
var getUser = function (user) {
    return `<tr id="tr_${user.id}"><td>${user.id}</td>
                       <td>${user.name}</td>
                       <td>
                       <button class="btn btn-danger" onclick="del(${user.id})">删除</button>
                       <button class="btn btn-warning" style="margin-left: 20px" onclick="update(${user.id})">修改</button>
                       </td>
                   </tr>`;
};

function go(pageNum) {
    $('#pageNum').val(pageNum);
    list1();
}

function list1() {
    var keyword = $('#keyword').val();//取得过滤条件
    var orderBy = $('#orderBy').val();//排序的字段
    var order = $('#order').val();//升序还是降序

    var pageNum = $('#pageNum').val() || 1;//获得当前的页码
    var pageSize = $('#pageSize').val() || 2;//每页的条数
    //$.get('/users').success(function (result) {
    //$.get('/users').then(function (result) {
    $.get(`/users?keyword=${keyword}&orderBy=${orderBy}&order=${order}&pageNum=${pageNum}&pageSize=${pageSize}`).then(function (result) {
        //先得到用户数组
        var data = result.data;
        var users = data.users;
        //对数组中的元素进行迭代
        var html = '';
        $.each(users, function (index, item) {
            //html+='<tr><th>item.id</th><th>item.name</th><th><button class="btn btn-danger">删除</button></th></tr>';
            html += getUser(item);
        });
        $('#userList').html(html);


        //拼出来分页组件
        //服务器端返回的 一共多少页 当前页
        //传递给服务器的 当前页 每页条数
        var pageNum=data.pageNum;//当前页数
        $('#pageNum').val(pageNum);
        var totalPage=data.totalPage;//总页数
        var pages='';
        if(pageNum>1){
	
            pages+=`<li><a onclick="go(${pageNum-1})" href="javascript:;" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>`;
        }
        for(var i=1;i<=totalPage;i++){//循环每个页码
            pages+=`<li class="${i==pageNum?'active':''}"><a onclick="go(${i})" href="javascript:;">${i}</a> </li>`;//每个页码对应一个li
        }
        if(pageNum<totalPage){
            pages+=`<li><a onclick="go(${pageNum + 1})" href="javascript:;" aria-label="Next">
        <span aria-hidden="true">&raquo;</span></a></li>
`;
        }
        $('#pager').html(pages); //把分页的dom设置到容器中
    });
}

function add() {
    $('#userId').val('');
    $('#name').val('');
    $('#userModal').modal('show');//显示模态窗口
}

function save() {
    var id = $('#userId').val();//得到id
    var name = $('#name').val();//取得用户名
    var user = {name: name};//组装要传到后台的对象

    if (id) {//修改
        user.id = id;
        $.ajax({
            url: '/users',
            method: 'PUT',
            data: user
        }).success(function (result) {//如果更新,服务器端应该返回更新后的user对象
            var user = result.data;
            //把原来tr替换成新的tr
            //$(`#tr_${id}`).html(getUser(user));
            /*$(`#tr_${id}`).after(getUser(user));
             $(`#tr_${id}`).remove();*/
            $(`#tr_${id}`).replaceWith(getUser(user));
            $('#alert').html('操作成功!');
            $('#userModal').modal('hide');
        }).error(function (err) {
            console.error(err);
            $('#alert').html('操作失败!');
        })

    } else {//新增
        $.post('/users', user).success(function (result) {
            var code = result.code;
            if (code == 'success') {
                var user = result.data;
                //console.log(result);
                $('#userList').append(getUser(user));
                $('#name').val('');
                $('#alert').html('操作成功!');
                $('#userModal').modal('hide');//隐藏
            } else {
                $('#alert').html('操作失败!');
            }
        })

    }
}

//删除用户
function del(id) {
    $.ajax({
        url: `/users?id=${id}`,//`/users+${id}`
        method: 'DELETE'
        //data:{id:id},
        //processData:true//处理数据,会将data对象转成查询字符串放在接口的后面
    }).success(function (result) {
        var user = result.user;
        var code = result.code;
        if (code == 'error') {
            $('#alert').html('操作失败!');
        } else {
            $(`#tr_${id}`).remove();
            $('#alert').html('操作成功!');
        }
    })

    //通过状态码操作
    /*success(function (result) {
     $(`#tr_${id}`).remove();
     $('#alert').html('操作成功!');
     }).error(function (result) {
     $('#alert').html('操作失败!');
     })*/
}


function update(id) {
    $.get(`/users?id=${id}`).success(function (result) {
        var user = result.data;
        $('#name').val(user.name);
        $('#userId').val(user.id);
        $('#userModal').modal('show');//显示
    })
}