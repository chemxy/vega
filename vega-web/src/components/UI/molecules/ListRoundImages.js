import {Row, Col} from 'react-bootstrap';
import RoundImage from '../atoms/RoundImage.js';
import PaulAguilar from "../../../assets/images/people/PaulAguilar.png";
import JonOliver from "../../../assets/images/people/JonOliver.png";
import ClaudineZhang from "../../../assets/images/people/ClaudineZhang.png";
import LovelinKumar from "../../../assets/images/people/LovelinKumar.png";
import MichelKouame from "../../../assets/images/people/MichelKouame.png";
import AngelinaDaCosta from "../../../assets/images/people/AngelinaDaCosta.png";
import BrijeshGupta from "../../../assets/images/people/BrijeshGupta.png";
import AmyFofana from "../../../assets/images/people/AmyFofana.png";

const ListRoundImages = (props) => {
	const images = [
		{"src": PaulAguilar, "name": "Paul Aguilar", "email": "", "pos":"CHIEF EXECUTIVE OFFICER"},
		{"src": JonOliver, "name": "Jon Oliver", "email": "", "pos":"CHIEF FINANCIAL OFFICER"},
		{"src": ClaudineZhang, "name": "Claudine Zhang", "email": "", "pos":"CHIEF OPEARTING OFFICER"},
		{"src": LovelinKumar, "name": "Lovelin Kumar", "email": "", "pos":"CHIEF TECHNOLOGY OFFICER"},
		{"src": MichelKouame, "name": "Michel Kouame", "email": "", "pos":"VP Sales"},
		{"src": AngelinaDaCosta, "name": "Angelina Da Costa", "email": "", "pos":"CHIEF MARKETING OFFICER"},
		{"src": BrijeshGupta, "name": "Brijesh Gupta", "email": "", "pos":"GENERAL COUNSEL AND SECRETARY"},
		{"src": AmyFofana, "name": "Amy Fofana", "email": "", "pos":"VP, BUSINESS OPERATIONS"}
	]

	const htmlForImages = images.map((image) =>  <Col xs={6} md={4}><RoundImage {...image} /></Col>);

	return (
		<Row>
			{htmlForImages}
		</Row>
	);
}
export default ListRoundImages;
