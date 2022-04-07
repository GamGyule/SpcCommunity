import Header from './Header';
import Footer from './Footer';
import { Fragment } from 'react/cjs/react.production.min';

const Layout = ({ children }) => (
    <Fragment>
        <Header />
        {children}
        <Footer />
    </Fragment>

);

export default Layout;