import { Button } from "react-bootstrap";
import { useHistory } from "react-router-dom";
const NewsDetails = ({ news }) => {
	const history = useHistory();
	const para = news.para.map((p) => <p>{p}</p>)
	const role = window.localStorage.getItem("role");
	function onEdit() {
		history.push({
			pathname: '/edit-news',
			state: { content: news }
		});
	}
	if (role && role == "ROLE_ADMIN") {
		return (
			<div className="mt-2 news">
				<p class="text-left">{news.date}</p>
				<h1>{news.h1}</h1>
				<h2>{news.h2}</h2>
				{para}
				<Button onClick={onEdit}>edit</Button>
			</div>
		);
	}
	else {
		return (
			<div className="mt-2 news">
				<p class="text-left">{news.date}</p>
				<h1>{news.h1}</h1>
				<h2>{news.h2}</h2>
				{para}
			</div>
		);
	}


}
export default NewsDetails;