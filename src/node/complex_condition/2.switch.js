const sendLog = (log) =>
  console.log(log);

const jumpTo = (route) =>
  console.log(route);

const onButtonClick = status => {
  switch (status) {
    case 1:
      sendLog('processing');
      jumpTo('IndexPage');
      break;
    case 2:
    case 3:
      sendLog('fail');
      jumpTo('FailPage');
      break;
    case 4:
      sendLog('success');
      jumpTo('SuccessPage');
      break;
    case 5:
      sendLog('cancel');
      jumpTo('CancelPage');
      break;
    default:
      sendLog('other');
      jumpTo('Index')
  }
};
