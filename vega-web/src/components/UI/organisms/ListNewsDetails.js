import NewsDetails from '../molecules/NewsDetails.js';
import {Row} from 'react-bootstrap';
const ListNewsDetails = ({listOfNews}) => {
	const generateHTMLForListOfNews = listOfNews.map((news) => <NewsDetails news={news} />)
	return (
		<Row>
			{generateHTMLForListOfNews}
		</Row>
		);
}
export default ListNewsDetails;