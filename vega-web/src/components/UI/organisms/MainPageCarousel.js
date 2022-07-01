import { Carousel, Row } from 'react-bootstrap';
import { useState } from 'react';
import first_image from "../../../assets/images/carousel_first.jpg";
import sec_image from "../../../assets/images/carousel_two.jpg";
import third_image from "../../../assets/images/carousel_third.jpg";

const MainPageCarousel = (props) => {
  const [index, setIndex] = useState(0);

  const handleSelect = (selectedIndex, e) => {
    setIndex(selectedIndex);
  };

  return (
    <Row>
      <Carousel activeIndex={index} onSelect={handleSelect} className="mt-2 mb-10">
        <Carousel.Item>
          <img id='index-page-image-1'
            className="d-block w-100"
            src={first_image}
            alt="First slide"
            height="600"
          />
          <Carousel.Caption>
            <h3 id='index-page-image-1-label'>First slide label</h3>
            <p id='index-page-image-1-caption'>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
          </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
          <img id='index-page-image-2'
            className="d-block w-100"
            src={sec_image}
            alt="Second slide"
            height="600"
          />

          <Carousel.Caption>
            <h3 id='index-page-image-2-label'>Second slide label</h3>
            <p id='index-page-image-2-caption'>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
          </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
          <img id='index-page-image-3'
            className="d-block w-100"
            src={third_image}
            alt="Third slide"
            height="600"
          />

          <Carousel.Caption>
            <h3 id='index-page-image-3-label'>Third slide label</h3>
            <p id='index-page-image-3-caption'>
              Praesent commodo cursus magna, vel scelerisque nisl consectetur.
            </p>
          </Carousel.Caption>
        </Carousel.Item>
      </Carousel></Row>)
}
export default MainPageCarousel;