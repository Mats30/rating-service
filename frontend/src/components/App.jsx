import React from 'react';
import HeaderContainer from './header/HeaderContainer'
import MovieList from './container/MovieList';

export const App = () => {
    return (
      <React.Fragment>
        <HeaderContainer />
        <MovieList />
      </React.Fragment>
    );
};
