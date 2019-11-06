import {NotificationManager} from "react-light-notifications";

export const loginAlert = () => {
    NotificationManager.warning({
        title: 'Warning!',
        message: 'You need to Sign in before!',
        showCloseButton: false,
        timeOut: 3000,
    });
};

export const successRate = () => {
    NotificationManager.success({
        title: 'Thank you!',
        message: 'Your rate has been sent successfully!',
        showCloseButton: false,
        timeOut: 3000,
    });
};