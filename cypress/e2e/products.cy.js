describe('POST products', () => {
  it('add product', () => {
    cy.request('POST', 'http://localhost:1323/products', {
      "Name": "Opelek2",
      "Description": "Mały ale wariat",
      "Price": 1999,
      "CategoryId": 4

    })
        .then((resp) => {
          expect(resp.status).to.eq(200);

          expect(resp.body).to.have.property('Category');
          expect(resp.body).to.have.property('ID');
          expect(resp.body).to.have.property('Name');
          expect(resp.body).to.have.property('Description');
          expect(resp.body).to.have.property('Price');

          Cypress.env('testProductId', resp.body.ID);
        })
  })
})

describe('GET products', () => {
  it('get products', () => {

    cy.request('GET', 'http://localhost:1323/products')
        .then((resp) => {
          expect(resp.status).to.eq(200);

          console.log(resp.body)
          const testProd = resp.body.slice(-1)[0];
          expect(testProd.ID).to.eq(Cypress.env('testProductId'));
          expect(testProd.Name).to.eq("Opelek2");
          expect(testProd.Description).to.eq("Mały ale wariat");
          expect(testProd.Price).to.eq(1999);
          expect(testProd.CategoryId).to.eq(4);
          expect(testProd).to.have.property('Category');
        })

  })
})

describe('DELETE product', () => {
    it('delete product', () => {

        cy.request('DELETE', `http://localhost:1323/products/${Cypress.env('testProductId')}`)
            .then((resp) => {
                expect(resp.status).to.eq(200);
            })

    })
})
