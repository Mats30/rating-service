import React from 'react';
import { connect } from "react-redux";
import { moviesUrl } from '../../config/config';
import MovieListItem from './MovieListItem';
import { successfulResponseMovies, errorResponse } from "../../actions/actions"

class MovieList extends React.Component {

    constructor() {
        super();
        this.update = this.update.bind(this);
    }

    state = {
        movies: []
    }

    async componentDidMount() {
        await fetch(moviesUrl)
            .then(response => response.json())
            .then(json => {
                this.setState({ movies: json.content })
                this.props.dispatch(successfulResponseMovies(this.state));
            })
            .catch(err => {
                this.props.dispatch(errorResponse(err));
            });
    }

    update(movie) {
        let newMovies = this.state.movies.slice();
        let newState = newMovies.map(item => {
            if (item.id !== movie.id) {
                return item
            }
            return movie;
        });
        this.setState({movies: newState})
    }


    render() {
        return (
            <ul className="movies-container">
                {
                    this.state.movies.map(movie => {
                        return <MovieListItem key={movie.id} movie={movie} onUpdateItem={this.update} />
                    })
                }
            </ul>
        );
    }


}

export default connect()(MovieList);