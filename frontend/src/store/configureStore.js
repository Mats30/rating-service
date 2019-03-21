import { createStore, applyMiddleware, compose } from "redux";
import rootReducer from '../reducers/reducer';
import { createLogger } from "redux-logger";

const __PROD__ = process.env.NODE_ENV === "production";

let composeEnhancers = compose;
if (!__PROD__ && window.__REDUX_DEVTOOLS_EXTENSION__) {
  composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__;
}


const logger = createLogger({
    level: "log",
    logger: console
});

const initialState = {
    movies: [],
    isModalOpen: false,
}


export default createStore (
    rootReducer,
    initialState,
    composeEnhancers(applyMiddleware(logger))
)