import React from 'react';
import { Route } from 'react-router-dom';
import UseState from './routes/useState';
import UseEffect from './routes/useEffect';
import UseEffectCallback from './routes/useEffectCallback';
import Rerender from './routes/rerender';
import UseReducer from './routes/useReducer';
import TwoCounter from './routes/twoCounter';
import UseMemo from './routes/useMemo';
import RerenderButton from './routes/rerenderButton';
import UseCallback from './routes/useCallback';
import ReactMemo from './routes/ReactMemo';
import UseRef from './routes/useRef';
import QueryUser from './routes/queryUser';
import MouseTracker from './routes/mouseTracker';

const Routes = () => (
  <div>
    <Route exact path="/" render={() => <div>index home</div> }/>
    <Route path="/useState" component={UseState}/>
    <Route path="/useEffect" component={UseEffect}/>
    <Route path="/useEffectCallback" component={UseEffectCallback}/>
    <Route path="/rerender" component={Rerender}/>
    <Route path="/useReducer" component={UseReducer}/>
    <Route path="/twoCounter" component={TwoCounter}/>
    <Route path="/useMemo" component={UseMemo}/>
    <Route path="/rerenderButton" component={RerenderButton}/>
    <Route path="/useCallback" component={UseCallback}/>
    <Route path="/ReactMemo" component={ReactMemo}/>
    <Route path="/useRef" component={UseRef}/>
    <Route path="/queryUser" component={QueryUser}/>
    <Route path="/mouseTracker" component={MouseTracker}/>
  </div>
);

export default Routes;
