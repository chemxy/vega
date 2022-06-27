import { useState } from "react";
import { Button, Form } from "react-bootstrap";
import { useHistory } from "react-router-dom";
import { doPost } from "../../service/BaseAPI";

const AddNews = () => {
    const history = useHistory();

    let [title, setTitle] = useState('');
    let [subtitle, setSubtitle] = useState('');
    let [content, setContent] = useState('');
    function doAdd() {
        // console.log(title);
        // console.log(subtitle);
        // console.log(content);
        const d = new Date();
        const datestring = (d.getMonth() + 1) + "." + d.getDate() + "." + d.getFullYear().toString().substring(2);
        // console.log(datestring)
        const body = {
            "date": datestring,
            "h1": title,
            "h2": subtitle,
            "para": [content]
        }
        doPost("http://localhost:8000/api/venus/add-news", body).then(res => {
            console.log(res)
        })
        history.push({
            pathname: '/news',
        });
    }

    function doCancel() {
        history.push({
            pathname: '/news',
        });
    }

    return <div>
        <Form>
            <Form.Group className="">
                <Form.Label>Heading</Form.Label>
                <div>
                    <textarea onChange={e => setTitle(e.target.value)} value={title} />
                </div>
            </Form.Group>
            <Form.Group className="">
                <Form.Label>Sub-heading</Form.Label>
                <div>
                    <textarea onChange={e => setSubtitle(e.target.value)} value={subtitle} />
                </div>
            </Form.Group>
            <Form.Group className="">
                <Form.Label>Content</Form.Label>
                <div>
                    <textarea onChange={e => setContent(e.target.value)} value={content} />
                </div>
            </Form.Group>
            <Button variant="primary" type="submit" onClick={doAdd}>
                Submit
            </Button>
            <Button variant="primary" type="submit" onClick={doCancel}>
                Cancel
            </Button>
        </Form>
    </div>
}

export default AddNews;