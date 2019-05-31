const sendLog = (log) =>
  console.log(log);

const jumpTo = (route) =>
  console.log(route);

const actions = {
  '1': ['processing', 'IndexPage'],
  '2': ['fail', 'FailPage'],
  '3': ['fail', 'FailPage'],
  '4': ['success', 'SuccessPage'],
  '5': ['cancel', 'CancelPage'],
  'default': ['other', 'Index'],
};

const onButtonClick = status => {
  let action = actions[status] || actions['default'],
    logName = action[0],
    pageName = action[1];

  sendLog(logName);
  jumpTo(pageName)
};
