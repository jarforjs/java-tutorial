const routes = new Map([
  [
    { identity: 'DISTRIBUTOR', assets: ['design', 'bill'] },
    () => this.ctx.redirect('https://b.antfinancial-corp.com/supplier/pub/SupplierPortal.htm'),
  ],
  [
    { identity: 'SUPPLIER', assets: ['activity', 'asset', 'invoice', 'sku'] },
    () => this.ctx.redirect(`${this.app.config.uriBroker.mrchstm.url}/mart/seller/guide.htm#/`),
  ],
])


const redirect = (status) => {
  if (status === 'DISTRIBUTOR') {

  }
}
