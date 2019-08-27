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
        {this.props.children/*render*/(this.state)}
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
  // 如果Mouse继承自React.PureComponent，则每次渲染<MouseTracker>，它都会生成一个新的函数作为<Mouse render>的prop，抵消了PureComponent组件的效果！
  // 为了绕过这个问题，有时可以定义一个prop作为实例方法，`this.renderTheCat`始终当我们在渲染中使用它时，它指向的是相同的函数
  // 如果你无法静态定义prop（例如：因为你需要关闭组件的props 和/或 state），则<Mouse>应该继承React.Component
  renderTheCat(mouse) {
    return <Cat mouse={mouse} />;
  }

  render() {
    return (
      <div>
        <h1>移动鼠标！</h1>
        <Mouse children/*render*/={mouse => (
          <Cat mouse={mouse}/>
        )}/>
        /*也可以像下面这样写*/
        <Mouse>
          {mouse => (
            <Cat mouse={mouse}/>
          )}
        </Mouse>
      </div>
    );
  }
}

export default MouseTracker
// export default withMouse(Cat)
