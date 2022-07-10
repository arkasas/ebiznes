describe('POST category', () => {
  it('add category', () => {

    cy.request('POST', 'http://localhost:1323/categories', {
      "Name": "Traktory",
    })
        .then((resp) => {
          expect(resp.status).to.eq(200)
          expect(resp.body).to.have.property('ID');
          expect(resp.body).to.have.property('Name');

          let testCat = resp.body;
          Cypress.env('testCatId', testCat.ID);\
          expect(testCat.Name).to.eq("Traktory");
        })
  })

  it('add duplicate category', () => {
    cy.request({
      method: 'POST',
      failOnStatusCode: false,
      url: 'http://localhost:1323/categories',
      body: {
        "name": "Testowa kategoria",
      }
    })
        .then((resp) => {
          expect(resp.status).to.eq(409)

        })
  })
})

describe('GET categories', () => {
  it('get categories', () => {

    cy.request('GET', 'http://localhost:1323/categories')
        .then((resp) => {
          expect(resp.status).to.eq(200);

          let testCat = resp.body.slice(-1)[0];
          expect(testCat.Name).to.eq("Traktory");
          expect(testCat.ID).to.eq(Cypress.env('testCatId'));
        })

  })
})


describe('DELETE categories', () => {
  it('delete categories', () => {

    cy.request('DELETE', `http://localhost:1323/categories/${Cypress.env('testCatId')}`)
        .then((resp) => {
          expect(resp.status).to.eq(200);
        })

  })
})
