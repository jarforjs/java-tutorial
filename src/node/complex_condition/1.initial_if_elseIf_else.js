const sendLog = (log) =>
  console.log(log);

const jumpTo = (route) =>
  console.log(route);

const onButtonClick = status => {
  if (status === 1) {
    sendLog('processing');
    jumpTo('IndexPage')
  } else if (status === 2) {
    sendLog('fail');
    jumpTo('FailPage')
  } else if (status === 3) {
    sendLog('fail');
    jumpTo('FailPage')
  } else if (status === 4) {
    sendLog('success');
    jumpTo('SuccessPage')
  } else if (status === 5) {
    sendLog('cancel');
    jumpTo('CancelPage')
  } else {
    sendLog('other');
    jumpTo('Index')
  }
};
