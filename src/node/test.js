const goto = (url) => window.open(url)

/**
 * 根据用户角色、页面作相应跳转
 * @param identity:角色信息
 * @param asset:页面资源
 */
const method = (identity, asset) => {
  if (identity === 'DISTRIBUTOR') {
    if (asset === 'design' || asset === 'bill') {
      goto('http://a')
    }
  } else if (identity === 'SUPPLIER') {
    if (asset === 'activity' || asset === 'asset' || asset === 'invoice') {
      goto('http://b')
    }
  }
}


const actions1 = new Map([
  ['DISTRIBUTOR_design', () => goto('http://a')],
  ['DISTRIBUTOR_bill', () => goto('http://a')],
  ['SUPPLIER_activity', () => goto('http://b')],
  ['SUPPLIER_asset', () => goto('http://b')],
  ['SUPPLIER_invoice', () => goto('http://b')],
])

const method1 = (identity, asset) => {
  const action1 = actions1.get(`${identity}_${asset}`)
  action1.call(this)
}


const actions2 = {
  'DISTRIBUTOR_design': () => goto('http://a'),
  'DISTRIBUTOR_bill': () => goto('http://a'),
  'SUPPLIER_activity': () => goto('http://b'),
  'SUPPLIER_asset': () => goto('http://b'),
  'SUPPLIER_invoice': () => goto('http://b'),
}

const method2 = (identity, asset) => {
  const action2 = actions2[`${identity}_${asset}`]
  action2.call(this)
}


const actions3 = new Map([
  [
    {identity:'DISTRIBUTOR', asset: 'design' }, () => goto('http://a'),
    {identity:'DISTRIBUTOR', asset: 'bill' }, () => goto('http://a')
  ],
  [
    {identity:'SUPPLIER', asset: 'activity' }, () => goto('http://b'),
    {identity:'SUPPLIER', asset: 'asset' }, () => goto('http://b'),
    {identity:'SUPPLIER', asset: 'invoice' }, () => goto('http://b'),
  ],
])

const method3 = (identity, asset) => {
  const action3 = [...actions3].filter(([key]) =>
    key.identity === identity && key.asset === asset)
  action3[0][1].call(this)
}


const actions4 = () => {
  const functionA = () => goto('http://a')
  const functionB = () => goto('http://b')
  return new Map([
    [
      {identity:'DISTRIBUTOR', assets: ['design', 'bill'] }, functionA,
    ],
    [
      {identity:'SUPPLIER', assets: ['activity', 'asset', 'invoice'] }, functionB,
    ],
  ])
}

const method4 = (identity, asset) => {
  const action4 = [...actions4].filter(([key]) =>
    key.identity === identity && key.assets.includes(asset))
  action4[0][1].call(this)
}


const actions5 = () => {
  const functionA = () => goto('http://a')
  const functionB = () => goto('http://b')
  const functionC = () => {/* do anything*/}
  return new Map([
    [/^DISTRIBUTOR_[1-4]$/, functionA],
    [/^DISTRIBUTOR_5$/, functionB],
    [/^DISTRIBUTOR_*$/, functionC],
  ])
}

const method5 = (identity, asset) => {
  const action5 = [...actions5].filter(([key]) =>
    key.test(`${identity}_${asset}`))
  action5[0][1].call(this)
}
