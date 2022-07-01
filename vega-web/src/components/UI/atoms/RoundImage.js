import { Image } from 'react-bootstrap';
const RoundImage = ({ src, name, email, pos }) => {
	const imageId = "leadership-image-" + name;
	const nameId = "leadership-name-" + name;
	const emailId = "leadership-email-" + name;
	const posId = "leadership-pos-" + name;
	return (
		<div className="text-center mt-2">
			<Image id={imageId} src={src} height="300" width="300" roundedCircle />
			<b><p id={nameId} className="text-center">{name}</p></b>
			<p id={emailId} className="text-center" >{pos}</p>
			<p id={posId} className="text-center" >{email}</p>
		</div>
	);
}
export default RoundImage;
