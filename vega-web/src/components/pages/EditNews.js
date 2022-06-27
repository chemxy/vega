import { useState } from "react";
import { Button, Form } from "react-bootstrap";
import { useHistory, useLocation } from "react-router-dom";
import { doPost } from "../../service/BaseAPI";

const EditNews = () => {
    const history = useHistory();
    const location = useLocation();
    let news = location.state.content;
    const defaultTitle = news.h1.toString();
    const defaultSubtitle = news.h2.toString();
    const defaultContent = news.para.toString();
    let [title, setTitle] = useState(defaultTitle);
    let [subtitle, setSubtitle] = useState(defaultSubtitle);
    let [content, setContent] = useState(defaultContent);
    function doEdit() {
        // console.log(title);
        // console.log(subtitle);
        // console.log(content);
        const d = new Date();
        const datestring = (d.getMonth() + 1) + "." + d.getDate() + "." + d.getFullYear().toString().substring(2);
        // console.log(datestring)
        const body = {
            "id": news.id,
            "content": {
                "date": datestring,
                "h1": title,
                "h2": subtitle,
                "para": [content]
            }
        }
        doPost("http://localhost:8000/api/venus/edit-news", body).then(res => {
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
            <Button variant="primary" type="submit" onClick={doEdit}>
                Submit
            </Button>
            <Button variant="primary" type="submit" onClick={doCancel}>
                Cancel
            </Button>
        </Form>
    </div>
}

export default EditNews;