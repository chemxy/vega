import UserRegistrationPageLayout from '../templates/UserRegistrationPageLayout.js';
import UserRegistrationForm from '../UI/organisms/UserRegistrationForm.js';
const UserRegistration = (props) => {
	return (
		<UserRegistrationPageLayout>
			<UserRegistrationForm />
		</UserRegistrationPageLayout>
		);
}
export default UserRegistration;