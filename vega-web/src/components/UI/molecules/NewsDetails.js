const NewsDetails = ({news}) => {
	const para = news.para.map((p) => <p>{p}</p>)
	return (
		<div className="mt-2">
			<p class="text-left">{news.date}</p>
			<h1>{news.h1}</h1>
			<h2>{news.h2}</h2>
			{para}
		</div>
		);
}
export default NewsDetails;