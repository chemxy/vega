import {Row, Image} from 'react-bootstrap';
const RoundImage = ({src, name, email, pos})	=> {
	return (
		<div className="text-center mt-2">
			<Image src={src} height="300" width="300" roundedCircle />
			<b><p className="text-center">{name}</p></b>
			<p className="text-center" >{pos}</p>
			<p className="text-center" >{email}</p>
		</div>
		);
}
export default RoundImage;
