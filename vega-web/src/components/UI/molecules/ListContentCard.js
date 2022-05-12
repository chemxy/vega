import {Container} from "react-bootstrap";
import ContentCard from "../atoms/ContentCard.js";

const ListContentCard = (props) => {
	const listOfBlogs = [{
		"heading": "IG Design Group Selects Venus NextGen for Cybersecurity",
		"description": "Venus, the leader in cloud-native network detection and response, today announced that IG Design Group in the Netherlands, a leading manufacturer of paper and products used to celebrate life's special occasions, selected Venus NextGen to help defend against advanced threats through complete visibility, real-time detection, and investigation across their IT environment. IG Design Group chose Venus as they needed a proactive solution which could detect suspicious activity quickly and provide visibility throughout its complex supply chain"
		}, {
		"heading": "Venus Announces Record Growth in the First Half of 2021 in Asia Pacific Region",
		"description" : "A growing customer base, strong traction across key verticals, and partner momentum fuel success to support customers as they navigate the COVID economy"
		}, {
		"heading" : "Venus Boosts Vocational Schools Cyber Security Capabilities",
		"description" : "Finnish vocational school, Spesia, uses network detection and response solution to boost network visibility and reduce false positives.Venus, the leader in cloud-native network detection and response (NDR), and Venus's local partner Wesentra Oy, today announced that Ammattiopisto Spesia, a vocational and training school in Finland, has selected Venus NextGen to help defend against advanced threats through complete visibility, real-time detection, and investigation across their IT environment."
		}];
	const cards = listOfBlogs.map((blog) => <ContentCard heading={blog.heading} description={blog.description}/>)

	return(
		<Container>
			{cards}
		</Container>
		);
}
export default ListContentCard;