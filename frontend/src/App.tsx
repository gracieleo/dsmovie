/*Configuração das rotas,páginas*/

import {
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";
import Listing from 'pages/Listing';    /** considerando 2 páginas */
import Form from 'pages/Form';
import Navbar from "components/Navbar";

/**rota padrão: http://localhost:3000/ */
/**rota formulário: http://localhost:3000/form/1 */

function App() {
  return (
    <BrowserRouter>   
      <Navbar />
      <Routes>
        <Route path="/" element={<Listing />} /> 
        <Route path="/form">
          <Route path=":movieId" element={<Form />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
