export const REQUEST_MOVIES_SUCCESS = "REQUEST_MOVIES_SUCCESS";
export const REQUEST_MOVIES_ERROR = "REQUEST_MOVIES_ERROR";
export const TOGGLE_MODAL = "TOGGLE_MODAL";


export const successfulResponseMovies = (movies) => {
  return {
    type: REQUEST_MOVIES_SUCCESS,
    payload: movies,
  };
};

export const errorResponse = (error) => {
  return {
    type: REQUEST_MOVIES_ERROR,
    error
  }
}

export const toggleModal = (isModalOpen) => {
  return {
    type: TOGGLE_MODAL,
    payload: isModalOpen
  }
}
