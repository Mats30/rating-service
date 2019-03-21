import React from 'react';
import { connect } from "react-redux";
import { baseUrl } from "../../config/config"
import { errorResponse } from '../../actions/actions';



class RatingModal extends React.Component {

    state = {
        id: "",
        rate: 5
    }

    constructor(props) {
        super(props);
        this.updateRating = this.updateRating.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    async updateRating(e) {
        e.preventDefault();
        let { id } = this.props;
        const updateUrl = baseUrl.concat(`/v1/movies/${id}/rate`);
        await fetch(updateUrl, {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ rate: this.state.rate })
        })
            .then(response => response.json())
            .then(json => {
                this.props.closeModal();
                this.props.onUpdateItem(json);
            })
            .catch(err => {
                this.props.dispatch(errorResponse(err));
            });
    }

    handleChange(e) {
        this.setState({ rate: e.target.value })
    }

    render() {
        return (
            <>
            <h2>{this.props.title}</h2>
            <h4>Your rating</h4>
            <form onSubmit={this.updateRating} className="modal-form">
                <input value={this.state.rate} onChange={this.handleChange} type="number" name="rate" min="1" max="10" step="1" />
                <input type="submit" value="Save" />
            </form>
            </>
        )
    }
}

export default connect()(RatingModal);