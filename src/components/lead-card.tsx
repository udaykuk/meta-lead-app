import { StyleSheet, View } from 'react-native';

import { ThemedText } from './themed-text';

import { Spacing } from '@/constants/theme';

type LeadCardProps = {
  name: string;
  email: string;
  phone: string;
};

export function LeadCard({ name = 'Try editing', email = 'app/index.tsx', phone = 'app/index.tsx' }: LeadCardProps) {
  return (
    <View style={styles.stepRow}>
      <ThemedText type="small">{name}</ThemedText>
      <ThemedText type="small">{email}</ThemedText>
      <ThemedText type="small">{phone}</ThemedText>

    </View>
  );
}

const styles = StyleSheet.create({
  stepRow: {

    flexDirection: 'column',
    justifyContent: 'space-between',
    padding: Spacing.one,
    borderRadius: Spacing.one,
    backgroundColor: '#012840',
    borderWidth: 1,
    borderColor: '#025959',
  },
   
});
