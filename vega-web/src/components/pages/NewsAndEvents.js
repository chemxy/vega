import { Container, Row } from 'react-bootstrap';
import Header from '../UI/organisms/Header.js';
import Footer from '../UI/organisms/Footer.js';
import ListNewsDetails from '../UI/organisms/ListNewsDetails.js';
import BlogPageLayout from '../templates/BlogPageLayout.js';
import { useState, useContext, useEffect } from 'react';
import { doPostFile, doGet } from '../../service/BaseAPI.js';

const NewsAndEvents = (props) => {
	const [newsList, setNewsList] = useState([]);
	useEffect(() => {
		doGet("http://localhost:8000/api/venus/get-news").then(res => {
			setNewsList(res);
		})
	});

	let listOfNews = newsList;
	let count = 0;
	if (listOfNews) {
		listOfNews.forEach(news => {
			news.id = count;
			count += 1;
		})
	}


	return (
		<BlogPageLayout listOfNews={listOfNews} />
	);
}
export default NewsAndEvents;