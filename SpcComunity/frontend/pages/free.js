<<<<<<< Updated upstream:SpcComunity/frontend/pages/board.js
import axios from 'axios'
import Head from 'next/head'
import Image from 'next/image'
import Layout from '../components/public/Layout';
import { useStore } from '../store/store.js'
import ListBoardComponent from './components/ListBoardComponent';


function BoardList() {
    return (
        <div> 
        <Router>            
          <HeaderComponent/> 
            <div className="container">
              <Switch>       
                <Route path = "/" exact component = {ListBoardComponent}></Route>
                <Route path = "/boardlist" component = {ListBoardComponent}></Route>
              </Switch>
            </div>
          <FooterComponent/> 
        </Router>
      </div>
 
    );
}

/*
const Index = () => (
    <Layout>
        <h2>게시판</h2>
    </Layout>
);*/

export default BoardList;
=======
import Layout from '../components/public/Layout';
const Index = () => (
    <Layout>
        <h2>자유 게시판</h2>
    </Layout>
);

export default Index
>>>>>>> Stashed changes:SpcComunity/frontend/pages/free.js
