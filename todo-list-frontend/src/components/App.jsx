import Header from "./Header"
import Footer from './Footer';
import {useState, useEffect} from 'react';
import axios from 'axios';

export default function App() {
  
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    //API endpoint url
    const apiUrl = 'http://localhost:8080/';

    //Get request to api
    axios.get(apiUrl)
      .then((response) => {
        setData(response.data); //Update the data state with the data responsed
        setLoading(false);
      })
      .catch((error) => {
        console.error('Error fetching data:',error);
        setLoading(false);  //Set loading to false in case of an error
      });
  }, []); //Empty dependencies array to run the effect only once

  return (
    <div>
      <Header />
      <div>
        {loading ? (
          <p>Loading...</p>
        ) : (
          <ul>
            {data.map((item) => (
              <li key={item.id}>
                {item.title},
                {item.description}
              </li>
            ))}
          </ul>
        )}
      </div>
      <Footer />
    </div>
  )
}