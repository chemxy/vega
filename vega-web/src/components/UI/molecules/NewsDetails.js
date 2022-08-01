import { Button } from "react-bootstrap";
import { useHistory } from "react-router-dom";
import { domain } from "../../../models/constants.js";
import { doPost } from "../../../service/BaseAPI.js";
// import { console.log } from "../../../../server/utils.js";

const NewsDetails = ({ news }) => {
	const history = useHistory();
	const para = news.para.map((p) => <p>{p}</p>)
	const role = window.localStorage.getItem("role");
	const addid = "news-edit-button-" + news.id;
	const deleteid = "news-delete-button-" + news.id;
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
		doPost("http://" + domain + ":8000/api/venus/delete-news", body).then(res => {
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
				<button id={addid} onClick={onEdit} className="btn btn-primary">edit</button>
				<button id={deleteid} onClick={onDelete} className="btn btn-danger ms-2">delete</button>
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