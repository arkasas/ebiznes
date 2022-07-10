import './App.css';
import {BrowserRouter, Routes, Route, Link, Navigate, useLocation} from "react-router-dom";
import Products from "./pages/product";
import 'bootstrap/dist/css/bootstrap.min.css';
import {Container, Nav, Navbar, NavDropdown} from "react-bootstrap";
import Order from "./pages/order";
import OrderEnd from "./pages/orderEnd";
import {useState} from "react";

export default function App() {
    const [currentUrl, setCurrentUrl] = useState(useLocation().pathname);
    const handleSelect = (href) => { setCurrentUrl(href) };

    return (
      <div className="App">
          <header className="">
              <Navbar bg="light" className="py-3 mb-5" >
                  <Container>
                      <Nav className='w-100' activeKey={currentUrl} onSelect={handleSelect}> {/*  */}
                          <Navbar.Toggle aria-controls="basic-navbar-nav" />
                          <Nav className='ms-auto' activeKey={currentUrl} onSelect={handleSelect}>
                              <Navbar.Collapse id="basic-navbar-nav" >
                                  <Nav.Link href="/products">Products</Nav.Link>
                                  <Nav.Link href="/order">Order</Nav.Link>
                              </Navbar.Collapse>
                          </Nav>
                      </Nav>
                  </Container>
              </Navbar>
          </header>

          <main>
              <Container>
                  <Routes>
                      <Route path="/" element={<Navigate to="products" />} />
                      <Route exact path='products' element={<Products />}> {/* isAdmin={isAdmin} */}</Route>
                      <Route path="order" element={<Order />} />
                      <Route path="order/finish" element={<OrderEnd></OrderEnd>} />
                  </Routes>
              </Container>
          </main>

      </div>
  );
}
