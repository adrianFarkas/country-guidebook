import {NotificationManager} from "react-light-notifications";

export const loginAlert = () => {
    NotificationManager.warning({
        title: 'Warning!',
        message: 'You need to Sign in before!',
        showCloseButton: false,
        timeOut: 3000,
    });
};