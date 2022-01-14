import axios from "axios";
import MovieCard from "components/MovieCard";
import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { MoviePage } from "types/movie";
import { BASE_URL } from "utils/requests";

function Listing() {

    const[pageNumber,setPageNumber] = useState(0);

    useEffect(()=> {
        axios.get(`${BASE_URL}/movies?size=12&page=0`)
    .then(resposta => {
        const data = resposta.data as MoviePage;
        console.log(data);
        setPageNumber(data.number);
    }); 
},[]);

    
    
    return (
        <>
        <p>{pageNumber}</p>
            <Pagination />

            <div className="container">
                <div className="row">
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>
                </div>
            </div>
        </>
    )
}

export default Listing;


/** <> </> = fragment */
/** col-lg-4 = a partir da largura 992px cada card ocupa 4 das 12 colunas (padrão) da tela ou seja serão 3 cards por coluna */
/** mb margin  botton */