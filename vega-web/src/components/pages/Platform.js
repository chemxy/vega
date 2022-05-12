import SimplePageLayout from '../templates/SimplePageLayout.js';


const GenerateHTMLForContent = (props) => {
	return (
		<div className="mt-2">
			<h1>Platform</h1>
			<p>Doing business in a digital economy demands agility, and corporate digital infrastructures have changed profoundly in response. But as businesses race to the cloud and expand activities across a globally distributed digital ecosystem, they must also reinvent cybersecurity to defend this expanded threat surface.</p>
			<p>Venus NextGen network defense platform is an innovative and comprehensive platform that provides multiple layers of protection including cloud-based sandboxing that stops both traditional threats and new advanced threats without impacting your network performance. It can be deployed across multiple physical locations as well as in Microsoft Azure, AWS, and Google Cloud Platform. Centralized management ensures that you can maintain a consistent security posture across your entire network perimeter.</p>
			<p>Venus NextGen platform offers a complete set of next-generation intrusion detection and prevention technologies to ensure real-time network protection against a broad range of network threats that can bypass traditional firewall security.</p>
			<h2>Deep Packet Inspection (DPI)</h2>
			<p>NextGen combines Deep Packet Inspection (DPI) and behavioral analysis to reliably detect and classify thousands of applications and sub-applications, regardless of advanced obfuscation, port hopping techniques, or encryption.</p>
			<h2>Intrusion Detection and Prevention System (IDS/IPS)</h2>
			<p>The Intrusion Detection and Prevention System (IDS/IPS) strongly enforces network security by providing real-time network protection against network vulnerabilities, exploits, and exposures in operating systems, applications, and databases.</p>
		</div>
		);
}

const Platform = (props) => {	
	return (
		<SimplePageLayout>
			<GenerateHTMLForContent />
		</SimplePageLayout>
		);
}

export default Platform;