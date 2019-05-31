const actions = new Map([
  ['guest_1', () => {/*do sth*/}],
  ['guest_2', () => {/*do sth*/}],
  ['guest_3', () => {/*do sth*/}],
  ['guest_4', () => {/*do sth*/}],
  ['guest_5', () => {/*do sth*/}],
  ['master_1', () => {/*do sth*/}],
  ['master_2', () => {/*do sth*/}],
  ['master_3', () => {/*do sth*/}],
  ['master_4', () => {/*do sth*/}],
  ['master_5', () => {/*do sth*/}],
  ['default', () => {/*do sth*/}],
]);

/**
 * 按钮点击事件
 * @param {string} identity 身份标识：guest客态 master主态
 * @param {number} status 活动状态：1 开团进行中 2 开团失败 3 开团成功 4 商品售罄 5 有库存未开团
 */
const onButtonClick = (identity, status) => {
  let action = actions.get(`${identity}_${status}`) || actions.get('default');
  action.call(this)
};


// 其实以上代码object也可以实现
const actions1 = {
  'guest_1': () => {/*do sth*/},
  'guest_2': () => {/*do sth*/},
  //....
};

const onButtonClick1 = (identity, status) => {
  let action = actions[`${identity}_${status}`] || actions['default'];
  action.call(this)
};
