const React = require("react");

class Cat extends React.Component{
  render() {
    const mouse = this.props.mouse
    return (
      <div style={{ border: '1px solid red', height: 300 }}>
        <img src="https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2106665142,2187631624&fm=173&app=25&f=JPG?w=218&h=146&s=48011D72534042EC0CC478ED0300E060" alt="cat" style={{ position: 'absolute', left: mouse.x, top: mouse.y }}/>
      </div>
    );
  }
}

// class Mouse extends React.Component{
class Mouse extends React.PureComponent{
  constructor(props) {
    super(props);
    this.handleMouseMove = this.handleMouseMove.bind(this);
    this.state = { x: 0, y: 0 };
  }

  handleMouseMove(e) {
    this.setState({
      x:e.clientX,
      y:e.clientY
    })
  }

  render() {
    return (
      <div style={{ height: '100%' }} onMouseMove={this.handleMouseMove}>
        {/*
          Instead of providing a static representation of what <Mouse> renders,
          use the `render` prop to dynamically determine what to render.
        */}
        {this.props.children(this.state)}
      </div>
    );
  }
}

function withMouse(Component) {
  return class extends React.Component {
    render() {
      return (
        <Mouse render={mouse => (
          <Component {...this.props} mouse={mouse}/>
        )}/>
      );
    }
  }
}

class MouseTracker extends React.Component{
  // 定义为实例方法，`this.renderTheCat`始终当我们在渲染中使用它时，它指向的是相同的函数

  render() {
    return (
      <div>
        <h1>移动鼠标！</h1>
        <Mouse children={mouse => (
          <Cat mouse={mouse}/>
        )}/>
      </div>
    );
  }
}

export default MouseTracker
// export default withMouse(Cat)
