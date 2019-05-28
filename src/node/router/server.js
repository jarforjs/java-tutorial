const http = require('http')
const url = require('url')

exports.start = function(route) {
  function onRequest(req, res) {
    const pathname = url.parse(req.url).pathname
    console.log('request for ' + pathname + ' received.')

    route(pathname)

    res.writeHead(200, { 'Content-Type': 'text/plain' })
    res.write('hello world')
    res.end()
  }

  http.createServer(onRequest).listen(8888)
  console.log('server has started')
}
