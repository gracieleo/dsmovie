import { ReactComponent as GithubIcon } from 'assets/img/github.svg';  /*import de imagem, GithubIcon = apelido*/
import './styles.css';

function Navbar() {

    return (
        <header>
            <nav className="container">
                <div className="dsmovie-nav-content">
                    <h1>DSMovie</h1>
                    <a href="https://https://github.com/gracieleo">
                        <div className="dsmovie-contact-container">
                            <GithubIcon />
                            <p className="dsmovie-contact-link">/gracieleo</p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>
    );
}

export default Navbar;   /** sempre exportar a função para ser usada */