import axios from 'axios'
import { GetServerSideProps } from 'next';
import Layout from '../components/public/Layout';
import { useStore } from '../store/store.js'
import {Container, Row, Col, Form, FormControl, InputGroup, Button} from 'react-bootstrap'
import ListComponent from '../components/common/ListBoardComponent.js'
import PagingComponent from '../components/common/PagingComponent';

function FreeBoard({ data, page }) {
  return (
    <Layout>
      <Container>
        <div className='center-child'>
          <ListComponent board="자유 게시판" data={data}></ListComponent>
          <PagingComponent data={data} page={page} board='free'></PagingComponent>
          
          <Row>
              <Form name="search-form" autoComplete="off" className='d-flex align-content-center'>
                <Col xs={4} md={2} className='me-1'>
                    <Form.Select name="name">
                      <option value="">검색 내용 선택</option>
                      <option value="title">제목</option>
                      <option value="contents">내용</option>
                      <option value="mix">제목+내용</option>
                      <option value="writer">닉네임</option>
                    </Form.Select>
                </Col>
                <Col xs={8} md={6} className='d-flex'>
                  <FormControl
                      type="text" 
                      name="keyword" 
                      className="form-control me-1"
                      id="search" 
                      placeholder="검색"
                  />
                  <Button onclick="getSearchList()" className="btn btn-success bi bi-search">Search</Button>
                </Col>    
              </Form>
          </Row>
        </div>
      </Container>
    </Layout>
  )
}

export const getServerSideProps = async ({ query: { page } }) => {
  if (page == null) {
    page = 1;
  }
  let data = [];
  await axios.get('http://127.0.0.1:9999/api/board/free?page=' + page).then(function (e) {
    data = e.data;
  });



  return { props: { data: data, page: page } }
}

function getSearchList(){
	$.ajax({
		type: 'GET',
		url : "/board/free/search",
		data : $("form[name=search-form]").serialize(),
		success : function(result){
			//테이블 초기화
			$('#boardtable > tbody').empty();
			if(result.length>=1){
				result.forEach(function(item){
					str='<tr>'
					str += "<td>"+item.idx+"</td>";
					str+="<td>"+item.writer+"</td>";
					str+="<td><a href = '/board/detail?idx=" + item.idx + "'>" + item.title + "</a></td>";
					str+="<td>"+item.date+"</td>";
					str+="<td>"+item.hit+"</td>";
					str+="</tr>"
					$('#boardtable').append(str);
        		})				 
			}
		}
	})
}



export default FreeBoard;