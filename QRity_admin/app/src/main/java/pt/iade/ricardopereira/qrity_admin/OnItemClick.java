package pt.iade.ricardopereira.qrity_admin;

import pt.iade.ricardopereira.qrity_admin.models.NotificationItem;

public interface OnItemClick {

    void onCheckMarkClick(NotificationItem notificationItem);
    void onCrossMarkClick(NotificationItem notificationItem);


}
