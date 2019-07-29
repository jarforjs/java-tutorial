import React from 'react';
import { BrowserRouter as Router, Link } from 'react-router-dom';
import Routes from './routes';
import './App.css';

function App() {
  return (
    <div className="App">
      <h2>Welcome to hangzhou!</h2>
      <Router>
        <div>
          <div className="menu">
            <Link to='useState'>useState</Link>
            <Link to='useEffect'>useEffect</Link>
            <Link to='useEffectCallback'>useEffectCallback</Link>
            <Link to='rerender'>rerender</Link>
            <Link to='useReducer'>useReducer</Link>
            <Link to='twoCounter'>twoCounter</Link>
            <Link to='useMemo'>useMemo</Link>
            <Link to='rerenderButton'>rerenderButton</Link>
            <Link to='useCallback'>useCallback</Link>
            <Link to='useCallback'>useCallback</Link>
            <Link to='ReactMemo'>ReactMemo</Link>
            <Link to='useRef'>useRef</Link>
            <Link to='queryUser'>queryUser</Link>
            <Link to='mouseTracker'>mouseTracker</Link>
          </div>
          <Routes/>
        </div>
      </Router>
    </div>
  );
}

export default App;
