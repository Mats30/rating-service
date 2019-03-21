import {
  REQUEST_MOVIES_ERROR,
  REQUEST_MOVIES_SUCCESS,
  TOGGLE_MODAL,
  SET_ID,
  SET_RATE,
  UPDATE_MOVIE
} from "../actions/actions";

export default (state, action) => {
  switch (action.type) {
    case REQUEST_MOVIES_SUCCESS:
      return { ...state, movies: action.payload };
    case REQUEST_MOVIES_ERROR:
      return { ...state, error: action.error };
    case TOGGLE_MODAL:
      return { ...state, isModalOpen: action.payload }
    default:
      return state;
  }
};