import { Button } from "react-bootstrap";
import { useHistory } from "react-router-dom";
import { doPost } from "../../../service/BaseAPI.js";

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

	function onDelete() {
		console.log(news.id)
		const body = {
			"id": news.id
		}
		doPost("http://localhost:8000/api/venus/delete-news", body).then(res => {
			console.log(res)
		})
		history.push({
			pathname: '/news',
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
				<Button onClick={onDelete}>delete</Button>
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