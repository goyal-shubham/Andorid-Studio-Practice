package edu.scu.sgoyal.recyclerview_cardview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by shubhamgoyal on 4/30/16.
 */


public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>
{
    private List<ContactInfo> contactList;

    public ContactAdapter(List<ContactInfo> contactList) {
        this.contactList = contactList;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.
                from(parent.getContext()).inflate(R.layout.name_card, parent, false);

        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position)
    {
        ContactInfo ci = contactList.get(position);
        holder.vEmail.setText(ci.name);
        holder.vSurname.setText(ci.surname);
        holder.vEmail.setText(ci.email);
        holder.vPhone.setText(ci.phone);
        holder.vTitle.setText(ci.name + " " + ci.surname);
    }

    @Override
    public int getItemCount()
    {
        return contactList.size();
    }


    public void onItemDismissed(int position)
    {
        contactList.remove(position);
        notifyItemRemoved(position);
    }

    public boolean onItemMoved(int fromPosition, int toPosition)
    {
        ContactInfo temp = contactList.get(fromPosition);
        contactList.set(fromPosition, contactList.get(toPosition));
        contactList.set(toPosition, temp);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }


    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        protected TextView vName;
        protected TextView vSurname;
        protected TextView vEmail;
        protected TextView vTitle;
        protected TextView vPhone;

        public ContactViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.txtName);
            vSurname = (TextView)  v.findViewById(R.id.txtSurname);
            vEmail = (TextView)  v.findViewById(R.id.txtEmail);
            vPhone = (TextView) v.findViewById(R.id.txtPhone);
            vTitle = (TextView) v.findViewById(R.id.title);
        }
    }


}


