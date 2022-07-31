import './App.css';
import { Routes, Route, Navigate, useLocation} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import {Container, Nav, Navbar} from "react-bootstrap";
import Order from "./pages/order";
import OrderEnd from "./pages/orderEnd";
import {useState} from "react";
import Products from "./pages/Products";
import useAuth from "./hook/useAuth";
import SignIn from "./pages/SignIn";
import Profile from "./pages/Profile";
import Logout from "./pages/Logout";

export default function App() {
    const [currentUrl, setCurrentUrl] = useState(useLocation().pathname);
    const handleSelect = (href) => { setCurrentUrl(href) };
    const {currentUserValue} = useAuth();
    const [forceRefresh] = useState();

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
                                  {currentUserValue() ? <Nav.Link href="/order">Order</Nav.Link> : null}
                                  {!currentUserValue() ? <Nav.Link href="/signin">Sign in</Nav.Link> : null}
                                  {currentUserValue() ? <Nav.Link href="logout">Logout</Nav.Link> : null}
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
                      <Route path="signin" element={<SignIn />} />
                      <Route path='logged' element={<Profile />} />
                      <Route path='logout' element={<Logout callback={forceRefresh} />} />

                  </Routes>
              </Container>
          </main>

      </div>
  );
}
