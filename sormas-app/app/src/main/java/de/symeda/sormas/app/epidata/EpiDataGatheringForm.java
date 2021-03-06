package de.symeda.sormas.app.epidata;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.symeda.sormas.app.R;
import de.symeda.sormas.app.backend.common.AbstractDomainObject;
import de.symeda.sormas.app.backend.epidata.EpiDataGathering;
import de.symeda.sormas.app.backend.location.Location;
import de.symeda.sormas.app.component.AbstractFormDialogFragment;
import de.symeda.sormas.app.component.LocationDialogBuilder;
import de.symeda.sormas.app.databinding.EpidataGatheringEditFragmentLayoutBinding;
import de.symeda.sormas.app.util.Consumer;

/**
 * Created by Mate Strysewske on 09.03.2017.
 */

public class EpiDataGatheringForm extends AbstractFormDialogFragment<EpiDataGathering> {

    private EpidataGatheringEditFragmentLayoutBinding binding;

    @Override
    public View onCreateDialogView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.epidata_gathering_edit_fragment_layout, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.setEpiDataGathering(getFormItem());
        binding.gatherDate.initialize(this);

        EpiDataGathering gathering = binding.getEpiDataGathering();
        LocationDialogBuilder.addLocationField(getActivity(), gathering.getGatheringAddress(), binding.gatherAddress, binding.formCpBtnAddress, new Consumer() {
            @Override
            public void accept(Object parameter) {
                if (parameter instanceof Location) {
                    binding.gatherAddress.setValue(parameter.toString());
                    binding.getEpiDataGathering().setGatheringAddress(((Location)parameter));
                }
            }
        });
    }

    @Override
    public AbstractDomainObject getData() {
        return binding.getEpiDataGathering();
    }
}
