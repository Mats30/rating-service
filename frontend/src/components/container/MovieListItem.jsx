import React from 'react';
import Modal from 'react-modal';
import RatingModal from './RatingModal';
import { connect } from "react-redux";
import { toggleModal, setId } from '../../actions/actions';

const modalStyle = {
    content: {
        top: '50%',
        left: '50%',
        right: 'auto',
        bottom: 'auto',
        marginRight: '-50%',
        transform: 'translate(-50%, -50%)'
    }
};

Modal.setAppElement('#root')
class MovieListItem extends React.Component {


    state = {
        isModalOpen: false,
        id: this.props.movie.id
    };

    constructor(props) {
        super(props);
        this.openModal = this.openModal.bind(this);
        this.closeModal = this.closeModal.bind(this);
    }

    openModal() {
        this.setState({ isModalOpen: true });
        this.props.dispatch(toggleModal(true));
    }

    closeModal() {
        this.setState({ isModalOpen: false });
        this.props.dispatch(toggleModal(false));
    }

    render() {
        const { id, title, date, genre, averageRating } = this.props.movie;
        return (
            <li className="movie-item" onClick={this.openModal}>
                    Title: {title} ==== Release date: {date} ==== Genre: {genre} ==== Average rating: {averageRating || ' No ratings'}
                    <Modal
                        isOpen={this.state.isModalOpen}
                        onRequestClose={this.closeModal}
                        style={modalStyle}>

                        <RatingModal id={id} closeModal={this.closeModal} onUpdateItem={this.props.onUpdateItem} title={title} />

                    </Modal>
            </li>)
    }
}

export default connect()(MovieListItem);