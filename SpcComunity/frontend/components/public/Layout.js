import Header from './Header';
import Footer from './Footer';

const Layout = ({ children }) => (
    <div className='bodyContainer'>
        <Header />
        {children}
        <Footer />
    </div>
);

export default Layout;