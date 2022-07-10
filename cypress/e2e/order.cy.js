describe('POST user', () => {
    it('add user', () => {

        cy.request('POST', 'http://localhost:1323/users', {
            "Username": "Testowy jan",
            "PasswordHash": "test",
            "Email": "jan@Email.com"
        })
            .then((resp) => {
                expect(resp.status).to.eq(200)
                expect(resp.body).to.have.property('ID');
                expect(resp.body).to.have.property('PasswordHash');
                expect(resp.body).to.have.property('Email');

                let testUser = resp.body;
                Cypress.env('testUserId', testUser.ID);
            })
    })

    it('add duplicate user', () => {
        cy.request({
            method: 'POST',
            failOnStatusCode: false,
            url: 'http://localhost:1323/users',
            body: {
                "Username": "Testowy jan",
                "PasswordHash": "test",
                "Email": "Email@Email.com"
            }
        })
            .then((resp) => {
                expect(resp.status).to.eq(409)
            })
    })
})

describe('GET users', () => {
    it('get users', () => {

        cy.request('GET', 'http://localhost:1323/users')
            .then((resp) => {
                expect(resp.status).to.eq(200);

                let testUser = resp.body.slice(-1)[0];
                expect(testUser.Username).to.eq("Testowy jan");
                expect(testUser.ID).to.eq(Cypress.env('testUserId'));
            })

    })
})

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

describe('POST order', () => {
  it('add to order', () => {
    cy.request('POST', 'http://localhost:1323/order', {
      "ProductID": Cypress.env('testProductId'),
      "UserID": Cypress.env('testUserId'),
    })
        .then((resp) => {
          expect(resp.status).to.eq(200)
          expect(resp.body).to.have.property('ID');
          expect(resp.body).to.have.property('User');
          expect(resp.body).to.have.property('Product');
        })
  })
})

describe('GET order by user id', () => {
    it('get order', () => {

        cy.request('GET', `http://localhost:1323/order/${Cypress.env('testUserId')}`)
            .then((resp) => {
                expect(resp.status).to.eq(200);

                let testCart = resp.body.slice(-1)[0];
                expect(testCart.ProductId).to.eq( Cypress.env('testProductId'));
                expect(testCart.UserId).to.eq( Cypress.env('testUserId'));
                expect(testCart).to.have.property('User');
                expect(testCart).to.have.property('Product');
                expect(testCart).to.have.property('UserId');
                expect(testCart).to.have.property('ProductId');
            })

    })
})

describe('POST pay order user id', () => {
    it('pay order', () => {

        cy.request('POST', `http://localhost:1323/payment/${Cypress.env('testUserId')}`)
            .then((resp) => {
                expect(resp.status).to.eq(200);
            })

    })

    it('get order is empty', () => {

        cy.request('GET', `http://localhost:1323/order/${Cypress.env('testUserId')}`)
            .then((resp) => {
                expect(resp.status).to.eq(200);
                expect(resp.body.length).to.eq(0);
            })

    })

})

describe('DELETE user', () => {
    it('delete user', () => {

        cy.request('DELETE', `http://localhost:1323/users/${Cypress.env('testUserId')}`)
            .then((resp) => {
                expect(resp.status).to.eq(200);
            })

    })
})
