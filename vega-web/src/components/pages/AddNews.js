import { useState } from "react";
import { Button, Form } from "react-bootstrap";
import { useHistory } from "react-router-dom";
import { doPost } from "../../service/BaseAPI";
import { domain } from '../../models/constants.js';
import debugLog from '../../server/utils';

const AddNews = () => {
    const history = useHistory();

    let [title, setTitle] = useState('');
    let [subtitle, setSubtitle] = useState('');
    let [content, setContent] = useState('');
    function doAdd() {
        // debugLog(title);
        // debugLog(subtitle);
        // debugLog(content);
        const d = new Date();
        const datestring = (d.getMonth() + 1) + "." + d.getDate() + "." + d.getFullYear().toString().substring(2);
        // debugLog(datestring)
        const body = {
            "date": datestring,
            "h1": title,
            "h2": subtitle,
            "para": [content]
        }
        doPost("http://" + domain + ":8000/api/venus/add-news", body).then(res => {
            debugLog(res)
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
        <Form className="m-5">
            <Form.Group className="">
                <Form.Label>Title</Form.Label>
                <div>
                    <textarea className="w-75" onChange={e => setTitle(e.target.value)} value={title} />
                </div>
            </Form.Group>
            <Form.Group className="">
                <Form.Label>Subtitle</Form.Label>
                <div>
                    <textarea className="w-75" onChange={e => setSubtitle(e.target.value)} value={subtitle} />
                </div>
            </Form.Group>
            <Form.Group className="">
                <Form.Label>Content</Form.Label>
                <div>
                    <textarea className="w-75 text-input" onChange={e => setContent(e.target.value)} value={content} />
                </div>
            </Form.Group>
            <button className="btn btn-outline-success" type="submit" onClick={doAdd}>
                Submit
            </button>
            <button className="btn btn-outline-danger ms-2" type="submit" onClick={doCancel}>
                Cancel
            </button>
        </Form>
    </div>
}

export default AddNews;